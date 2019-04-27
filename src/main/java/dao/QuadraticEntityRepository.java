package dao;


import model.QuadraticEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuadraticEntityRepository extends CrudRepository<QuadraticEntity, Long> {

    QuadraticEntity findByABC(Integer a, Integer b, Integer c);

}
