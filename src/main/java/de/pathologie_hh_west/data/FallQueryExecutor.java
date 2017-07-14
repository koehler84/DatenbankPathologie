package de.pathologie_hh_west.data;

import de.pathologie_hh_west.model.Fall;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by eike on 13.07.2017.
 */
@Component
public class FallQueryExecutor {
	
	@PersistenceContext
	private EntityManager entityManager;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public List<Fall> getItemsByFilter(List<Filter> filters) throws IllegalArgumentException {
		if (filters.size() < 1) {
			throw new IllegalArgumentException("No filters specified.");
		}
		
		String query = createJPQLQuery(filters);
		logger.info("Executing JPQL query: ".concat(query), query);
		return entityManager.createQuery(query, Fall.class).getResultList();
	}
	
	public String createJPQLQuery(List<Filter> filters) {
		String query = "SELECT f FROM Fall AS f WHERE";
		
		for (Filter filter : filters) {
			query = query.concat(" f." + filter.getFieldName());
			query = query.concat(" " + filter.getEquality().getStringOperator());
			query = query.concat(" '" + filter.getFilterValue() + "'");
			query = query.concat(" and");
		}
		query = query.substring(0, query.length() - " and".length());
		return query;
	}
	
	public static class Filter {
		
		private String fieldName;
		private Equality equality;
		private String filterValue;
		
		public Filter() {
		}
		
		public Filter(String fieldName, Equality equality, String filterValue) {
			if (fieldName.equals("") || equality == null || filterValue.equals(""))
				throw new IllegalArgumentException("Could not create Filter object: Parameter values are not expected.");
			this.fieldName = fieldName;
			this.equality = equality;
			this.filterValue = filterValue;
		}
		
		public String getFieldName() {
			return fieldName;
		}
		
		public void setFieldName(String fieldName) {
			if (fieldName == null || fieldName.equals("")) throw new IllegalArgumentException("Could not update Filter object: Parameter value is not expected.");
			this.fieldName = fieldName;
		}
		
		public Equality getEquality() {
			return equality;
		}
		
		public void setEquality(Equality equality) {
			if (equality.equals("")) throw new NullPointerException("Could not update Filter object: Parameter value is not expected.");
			this.equality = equality;
		}
		
		public String getFilterValue() {
			return filterValue;
		}
		
		public void setFilterValue(String filterValue) {
			if (filterValue.equals("")) throw new IllegalArgumentException("Could not update Filter object: Parameter value is not expected.");
			this.filterValue = filterValue;
		}
	}
	
	public enum Equality {
		EQUAL {
			@Override
			public String getStringOperator() {
				return "=";
			}
			
			@Override
			public Equality getNext() {
				return NOT_EQUAL;
			}
		}, NOT_EQUAL {
			@Override
			public String getStringOperator() {
				return "!=";
			}
			
			@Override
			public Equality getNext() {
				return BIGGER;
			}
		}, BIGGER {
			@Override
			public String getStringOperator() {
				return ">";
			}
			
			@Override
			public Equality getNext() {
				return SMALLER;
			}
		}, SMALLER {
			@Override
			public String getStringOperator() {
				return "<";
			}
			
			@Override
			public Equality getNext() {
				return EQUAL;
			}
		};
		
		public abstract String getStringOperator();
		public abstract Equality getNext();
		
		public static Equality fromString(String operator) {
			switch (operator) {
				case "=":case "==": return EQUAL;
				case "!=": return NOT_EQUAL;
				case ">": return BIGGER;
				case "<": return SMALLER;
				default: return null;
			}
		}
	}
}
