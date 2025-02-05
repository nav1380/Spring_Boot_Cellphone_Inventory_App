package com.Gadget.Mobile.repository;

import com.Gadget.Mobile.model.Cellphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CellphoneRepository extends JpaRepository<Cellphone, Long> {
}
