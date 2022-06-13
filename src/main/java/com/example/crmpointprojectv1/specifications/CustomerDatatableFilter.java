package com.example.crmpointprojectv1.specifications;

import com.example.crmpointprojectv1.model.Customer;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


public class CustomerDatatableFilter implements Specification<Customer> {

    private String userQuery;

    @Override
    public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();

        if (userQuery != null && !userQuery.equals("")) {
            predicates.add(criteriaBuilder.like(root.get("firstName"), '%' + userQuery + '%'));
            predicates.add(criteriaBuilder.like(root.get("lastName"), '%' + userQuery + '%'));
            predicates.add(criteriaBuilder.like(root.get("city"), '%' + userQuery + '%'));
            predicates.add(criteriaBuilder.like(root.get("emailAddress"), '%' + userQuery + '%'));
            predicates.add(criteriaBuilder.like(root.get("phoneNumber"), '%' + userQuery + '%'));
            predicates.add(criteriaBuilder.like(root.get("country"), '%' + userQuery + '%'));
            predicates.add(criteriaBuilder.like(root.get("company"), '%' + userQuery + '%'));
        }

        return (!predicates.isEmpty()
                ? criteriaBuilder.or(predicates.toArray(new Predicate[0]))
                : null);
    }
}
