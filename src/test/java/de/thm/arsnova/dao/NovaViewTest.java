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
package de.thm.arsnova.dao;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.junit.Test;

public class NovaViewTest {

	@Test
	public void setKeyShouldAcceptSingleArgument() {
		NovaView v = new NovaView(null);
		v.setKey("foo");
		assertEncodedEquals("key", "\"foo\"", v.getQueryString());
	}

	@Test
	public void setKeyShouldAcceptMultipleArgument() {
		NovaView v = new NovaView(null);
		v.setKey("foo", "bar", "baz");
		assertEncodedEquals("key", "[\"foo\",\"bar\",\"baz\"]", v.getQueryString());
	}

	@Test
	public void setStartKeyShouldAcceptSingleArgument() {
		NovaView v = new NovaView(null);
		v.setStartKey("foo");
		assertEncodedEquals("startkey", "\"foo\"", v.getQueryString());
	}

	@Test
	public void setStartKeyShouldAcceptSingleArgumentArray() {
		NovaView v = new NovaView(null);
		v.setStartKeyArray("foo");
		assertEncodedEquals("startkey", "[\"foo\"]", v.getQueryString());
	}

	@Test
	public void setEndKeyShouldAcceptSingleArgumentArray() {
		NovaView v = new NovaView(null);
		v.setEndKeyArray("foo");
		assertEncodedEquals("endkey", "[\"foo\"]", v.getQueryString());
	}

	@Test
	public void setEndKeyShouldAcceptSingleArgument() {
		NovaView v = new NovaView(null);
		v.setEndKey("foo");
		assertEncodedEquals("endkey", "\"foo\"", v.getQueryString());
	}

	@Test
	public void setStartKeyShouldAcceptMultipleArgument() {
		NovaView v = new NovaView(null);
		v.setStartKey("foo", "bar", "baz");
		assertEncodedEquals("startkey", "[\"foo\",\"bar\",\"baz\"]", v.getQueryString());
	}

	@Test
	public void setEndKeyShouldAcceptMultipleArgument() {
		NovaView v = new NovaView(null);
		v.setEndKey("foo", "bar", "baz");
		assertEncodedEquals("endkey", "[\"foo\",\"bar\",\"baz\"]", v.getQueryString());
	}

	@Test
	public void keysShouldSupportEmptyObject() {
		NovaView v = new NovaView(null);
		v.setKey("foo", "bar", "{}");
		assertEncodedEquals("key", "[\"foo\",\"bar\",{}]", v.getQueryString());
	}

	@Test
	public void arrayKeysShouldNotEnquoteNumbers() {
		NovaView v = new NovaView(null);
		v.setKey("foo", "bar", "2");
		assertEncodedEquals("key", "[\"foo\",\"bar\",2]", v.getQueryString());
	}

	@Test
	public void singleArrayKeysShouldNotEnquoteNumbers() {
		NovaView v1 = new NovaView(null);
		NovaView v2 = new NovaView(null);
		v1.setStartKeyArray("2");
		v2.setEndKeyArray("2");
		assertEncodedEquals("startkey", "[2]", v1.getQueryString());
		assertEncodedEquals("endkey", "[2]", v2.getQueryString());
	}

	private void assertEncodedEquals(String key, String expected, String actual) {
		try {
			assertEquals(key + "=" + URLEncoder.encode(expected, "UTF-8"), actual);
		} catch (UnsupportedEncodingException e) {
			fail(e.getLocalizedMessage());
		}
	}
}
