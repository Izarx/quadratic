package ua.com.zakharko.ihor.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.zakharko.ihor.model.QuadraticEntity;

@Repository
public interface QuadraticEntityRepository extends CrudRepository<QuadraticEntity, Long>
{

}
