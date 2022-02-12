package com.coding.languages.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="languages")
public class Language {
		
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private Long id;
			
			@NotNull (message="Please provide a version")
			@Size(min=1, message="Must have version number")
			private String version;
			 
			@NotNull (message="Please provide name")
			@Size(min=2, max =20, message="Must have an name with 2-20 characters")
			private String name;
			 
			 @NotNull (message="Please provide creator")
			@Size(min = 2, max = 20, message="Creator name must be minimum 2 characters, max 20")
			private String creator;
			 

		 
		    @Column(updatable=false)
		    @DateTimeFormat(pattern="yyyy-MM-dd")
		    private Date createdAt;
		    @DateTimeFormat(pattern="yyyy-MM-dd")
		    private Date updatedAt;
			 
			 
		public Language() {
			
		}
		
		public Language(String name, String creator, String version) {
			this.name=name;
			this.creator=creator;
			this.version=version;
			
		}

		
		
		
		
		
		
		
		
		
		
		
		
		@PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCreator() {
			return creator;
		}

		public void setCreator(String creator) {
			this.creator = creator;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

	
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
}
