package com.jmr.domain;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.jmr.enus.ImageExtension;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
public class Produto{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column
    private String name;
    @Column
    private Long size;
    @Column
    @Enumerated(EnumType.STRING)
    private ImageExtension extension;
    @Column
    @CreatedDate
    private LocalDateTime uploadDate;
    @Column
    private String tags;
    @Column
    @Lob
    private byte[] file;
		
	public Produto() {

	}

	public Produto(String id, String name, Long size, ImageExtension extension, LocalDateTime uploadDate, String tags,
			byte[] file) {
		super();
		this.id = id;
		this.name = name;
		this.size = size;
		this.extension = extension;
		this.uploadDate = uploadDate;
		this.tags = tags;
		this.file = file;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public ImageExtension getExtension() {
		return extension;
	}

	public void setExtension(ImageExtension extension) {
		this.extension = extension;
	}

	public LocalDateTime getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(LocalDateTime uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(file);
		result = prime * result + Objects.hash(extension, id, name, size, tags, uploadDate);
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
		Produto other = (Produto) obj;
		return extension == other.extension && Arrays.equals(file, other.file) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(size, other.size)
				&& Objects.equals(tags, other.tags) && Objects.equals(uploadDate, other.uploadDate);
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", name=" + name + ", size=" + size + ", extension=" + extension + ", uploadDate="
				+ uploadDate + ", tags=" + tags + ", file=" + Arrays.toString(file) + "]";
	}	
	
	
	
}
