package ua.com.zakharko.ihor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.zakharko.ihor.dao.QuadraticEntityRepository;
import ua.com.zakharko.ihor.model.QuadraticEntity;

@Service
public class QuadraticEntityServiceImpl implements QuadraticEntityService {

    @Autowired
    private QuadraticEntityRepository repository;

    @Override
    public QuadraticEntity save(final QuadraticEntity quadraticEntity)
    {
        return repository.save(quadraticEntity);
    }

    @Override
    public QuadraticEntity getById(final Long id)
    {
        return repository.findById(id).orElse(null);
    }
}
