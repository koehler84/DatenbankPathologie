package de.pathologie_hh_west.data;

import de.pathologie_hh_west.model.FallID;
import de.pathologie_hh_west.model.Fall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by VaniR on 10.07.2017.
 */
@Repository
public interface FallRepository extends JpaRepository<Fall, FallID> {
}
