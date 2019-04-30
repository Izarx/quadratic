package ua.com.zakharko.ihor.services;

import ua.com.zakharko.ihor.model.QuadraticEntity;

public interface QuadraticEntityService {

    QuadraticEntity save(QuadraticEntity quadraticEntity);

    QuadraticEntity getById(Long id);
}
