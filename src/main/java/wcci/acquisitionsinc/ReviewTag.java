package wcci.acquisitionsinc;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class ReviewTag {

	private String name;

	@Id
	@GeneratedValue
	private Long id;

	@ManyToMany(mappedBy = "reviewTags")
	private Collection<Review> reviews;

	public ReviewTag() {

	}

	public ReviewTag(String name) {
		this.name = name;
		
	}

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public Collection<Review> getReviews() {
		return reviews;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReviewTag other = (ReviewTag) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
