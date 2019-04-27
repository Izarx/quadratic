package services;

import model.QuadraticEntity;

public interface QuadraticEntityService {

    QuadraticEntity findByABC(final Integer a, final Integer b, final Integer c);

    QuadraticEntity save(QuadraticEntity quadraticEntity);
}
