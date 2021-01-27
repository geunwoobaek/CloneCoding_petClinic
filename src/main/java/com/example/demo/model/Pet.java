package com.example.demo.model;

import com.example.demo.model.comon.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Data
@Table(name = "pets")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Pet extends BaseEntity {

	private String name;

	@Column(name = "birth_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate birthDate;

	@Transient
	private Set<Visit> visits = new LinkedHashSet<>();

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "type_id")
	private Type type;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "onwer_id")
	private Owner owner = null;

	// 연관관계매핑
	public void setType(Type type) {
		type.AddPet(this);
		this.type = type;
	}

	protected Set<Visit> getVisitsInternal() {
		if (this.visits == null) {
			this.visits = new HashSet<>();
		}
		return this.visits;
	}

	protected void setVisitsInternal(Collection<Visit> visits) {
		this.visits = new LinkedHashSet<>(visits);
	}

	public List<Visit> getVisits() {
		List<Visit> sortedVisits = new ArrayList<>(getVisitsInternal());
		PropertyComparator.sort(sortedVisits, new MutableSortDefinition("date", false, false));
		return Collections.unmodifiableList(sortedVisits);
	}

	public void addVisit(Visit visit) {
		getVisitsInternal().add(visit);
		visit.setPetId(this.getId());
	}

}
