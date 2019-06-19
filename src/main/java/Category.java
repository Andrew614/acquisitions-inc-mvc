import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import wcci.acquisitionsinc.Review;

@Entity
public class Category {
	private String name;

	@Id
	@GeneratedValue
	private Long id;

	@OneToMany(mappedBy = "category")
	private Collection<Review> reviews;

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public Collection<Review> getReviews() {
		return reviews;
	}

	protected Category() {

	}

	public Category(String name) {
		this.name = name;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
