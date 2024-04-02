package com.jmr.dto;

import java.time.LocalDate;
import java.util.Objects;

public class ProdutoDTO {
	
    private String url;
    private String name;
    private String extension;
    private Long size;
    private LocalDate uploadDate;
    
    public ProdutoDTO() {
        }   
	
    public ProdutoDTO(String url, String name, String extension, Long size, LocalDate uploadDate) {
		this.url = url;
		this.name = name;
		this.extension = extension;
		this.size = size;
		this.uploadDate = uploadDate;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public LocalDate getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(LocalDate uploadDate) {
		this.uploadDate = uploadDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(extension, name, size, uploadDate, url);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoDTO other = (ProdutoDTO) obj;
		return Objects.equals(extension, other.extension) && Objects.equals(name, other.name)
				&& Objects.equals(size, other.size) && Objects.equals(uploadDate, other.uploadDate)
				&& Objects.equals(url, other.url);
	}    

}
