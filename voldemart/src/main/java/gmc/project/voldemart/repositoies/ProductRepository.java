package gmc.project.voldemart.repositoies;

import org.springframework.data.repository.CrudRepository;

import gmc.project.voldemart.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

}
