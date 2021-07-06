package in.pritha.repository;

import javax.validation.Valid;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.pritha.model.BookingEntity;
import in.pritha.model.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<BookingEntity, Integer> {

	boolean save(@Valid Payment payment);

}
