package de.pathologie_hh_west.model;

import java.time.LocalDate
import javax.persistence.*

/**
 * Created by VaniR on 10.07.2017.
 */
@Entity
@Table(
		uniqueConstraints = arrayOf(UniqueConstraint(columnNames = arrayOf("geburtsDatum", "vorname", "nachname")))
)
class Patient {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	var id: Long? = null
	@Column(name = "vorname")
	lateinit var vorname: String
	@Column(name = "nachname")
	lateinit var nachname: String
	var alternativName: String? = null
	@Column(name = "geburtsDatum")
	lateinit var geburtsDatum: LocalDate
	@Embedded
	lateinit var adresse: Adresse
	@OneToMany(cascade = arrayOf(CascadeType.ALL))
	@JoinColumn(name = "patientID", referencedColumnName = "ID", nullable = false)
	val faelle: MutableSet<Fall> = HashSet<Fall>()
	@OneToOne(cascade = arrayOf(CascadeType.ALL))
	lateinit var patientenZusatzdaten: PatientenZusatzdaten
	
	fun getFallById(eNummer: ENummer, befundTyp: BefundTyp, index: Int): Fall {
		for (fall in faelle) {
			if (fall.fallID.geteNummer().value == eNummer.value
					&& fall.fallID.befundTyp == befundTyp)
				return fall;
		}
		throw RuntimeException()
	}
}
