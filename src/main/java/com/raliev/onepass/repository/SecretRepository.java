package com.raliev.onepass.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.raliev.onepass.entity.Secret;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

public interface SecretRepository extends CrudRepository<Secret, String> {

	@Query(value = "SELECT * FROM secret s WHERE s.expiration_date <= ?1", nativeQuery = true)
	List<Secret> getExpiredSecretsByDate(LocalDateTime date);

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM secret WHERE expiration_date <= ?1", nativeQuery = true)
	void deleteExpiredSecretsByDate(LocalDateTime date);

	@Query(value = "SELECT COUNT(*) FROM secret s WHERE s.expiration_date <= ?1", nativeQuery = true)
	long countExpiredSecrets(LocalDateTime date);

}
