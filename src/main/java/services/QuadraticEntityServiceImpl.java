package services;

import dao.QuadraticEntityRepository;
import model.QuadraticEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuadraticEntityServiceImpl implements QuadraticEntityService
{
    @Autowired
    QuadraticEntityRepository quadraticEntityRepository;

    @Override
    public QuadraticEntity findByABC(final Integer a, final Integer b, final Integer c)
    {
        return quadraticEntityRepository.findByABC(a, b, c);
    }

    @Override
    public QuadraticEntity save(QuadraticEntity quadraticEntity) {
        return quadraticEntityRepository.save(quadraticEntity);
    }
}
