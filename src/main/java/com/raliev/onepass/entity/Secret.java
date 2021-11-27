package com.raliev.onepass.entity;

import com.raliev.onepass.dto.SecretRequestDto;
import com.raliev.onepass.utils.Expiration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "secret")
public class Secret implements Serializable {

	private static final long serialVersionUID = -5852896062346049995L;

	@Id
	private String uuid;

	@Column(name = "data", nullable = false)
	private String data;

	@Column(name = "expiration_date", nullable = true)
	private LocalDateTime expirationDate;

	public Secret() {
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}

	public static Secret of(SecretRequestDto dto) {
		Secret secret = new Secret();
		secret.setData(dto.getData());
		secret.setExpirationDate(Expiration.calcExpirationDateTime(dto.getLifetime()));
		return secret;
	}

	@Override
	public String toString() {
		return "[ id: " + uuid +
				", data: " + data +
				", expirationDate: " + expirationDate + " ]\n";
	}
}
