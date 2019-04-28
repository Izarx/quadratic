package ua.com.zakharko.ihor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.zakharko.ihor.dao.QuadraticEntityRepository;
import ua.com.zakharko.ihor.model.QuadraticEntity;

@Service
public class QuadraticEntityServiceImpl implements QuadraticEntityService {

    @Autowired
    QuadraticEntityRepository repository;

    @Override
    public QuadraticEntity findByABC(final Integer a, final Integer b, final Integer c)
    {
        return repository.findByABC(a, b, c);
    }

    @Override
    public QuadraticEntity save(final QuadraticEntity quadraticEntity)
    {
        return repository.save(quadraticEntity);
    }
}