package kth.chem.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@AllArgsConstructor
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Size(min = 4, max = 20, message = "Length should not be greater than 4 and less than 20")
	@NotEmpty(message = "username is required.")
	@Column(nullable = false, length = 225, unique = true)
	private String name;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, name = "insert_date", updatable = false)
	private Date insertDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, name = "update_date")
	private Date updateDate;
}
