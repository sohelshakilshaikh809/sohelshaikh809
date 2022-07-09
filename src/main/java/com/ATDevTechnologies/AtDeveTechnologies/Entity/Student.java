package com.ATDevTechnologies.AtDeveTechnologies.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

    @Entity
	@Table(name="student")
	public class Student {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		private String name;
		private long std;
		private String div;
		
		public Student() {
			super();
		}

		public Student(long id, String name, long std, String div) {
			super();
			this.id = id;
			this.name = name;
			this.std = std;
			this.div = div;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public long getStd() {
			return std;
		}

		public void setStd(long std) {
			this.std = std;
		}

		public String getDiv() {
			return div;
		}

		public void setDiv(String div) {
			this.div = div;
		}

		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + ", std=" + std + ", div=" + div + "]";
		}
		
	}