/*
 * Copyright (C) 2012 THM webMedia
 *
 * This file is part of ARSnova.
 *
 * ARSnova is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ARSnova is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.thm.arsnova.entities;

import java.io.Serializable;
import java.util.List;

public class Session implements Serializable {

	private static final long serialVersionUID = 1L;

	private String type;
	private String name;
	private String shortName;
	private String keyword;
	private String creator;
	private boolean active;
	private long lastOwnerActivity;
	private String courseType;
	private String courseId;
	private List<String> _conflicts;

	private String _id;
	private String _rev;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public long getLastOwnerActivity() {
		return lastOwnerActivity;
	}

	public void setLastOwnerActivity(long lastOwnerActivity) {
		this.lastOwnerActivity = lastOwnerActivity;
	}

	public void set_id(String id) {
		_id = id;
	}

	public String get_id() {
		return _id;
	}

	public void set_rev(String rev) {
		_rev = rev;
	}

	public String get_rev() {
		return _rev;
	}
	
	public void set_conflicts(List<String> conflicts) {
		_conflicts = conflicts;
	}

	public List<String> get_conflicts() {
		return _conflicts;
	}

	public boolean isCreator(User user) {
		return user.getUsername().equals(this.creator);
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public boolean isCourseSession() {
		return (this.getCourseId() != null) && (!this.getCourseId().isEmpty());
	}
	
	@Override
	public String toString() {
		return "User [keyword=" + keyword+ ", type=" + type + "]";
	}
}
