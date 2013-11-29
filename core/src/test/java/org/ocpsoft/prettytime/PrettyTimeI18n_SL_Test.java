/*
 * Copyright 2012 <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ocpsoft.prettytime;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

public class PrettyTimeI18n_SL_Test {

	private Locale locale;

	@Before
	public void setUp() throws Exception {
		locale = new Locale("sl");
		Locale.setDefault(locale);
	}

	@Test
	public void testRightNow() throws Exception {
		PrettyTime t = new PrettyTime(new Date(0), locale);
		assertEquals("pravkar", t.format(new Date(6000)));
	}

	@Test
	public void testMinutesFromNow() throws Exception {
		PrettyTime t = new PrettyTime(new Date(0), locale);
		assertEquals("čez 12 minut", t.format(new Date(1000 * 60 * 12)));
	}

	@Test
	public void testMinutesAgo() throws Exception {
		PrettyTime t = new PrettyTime(new Date(1000 * 60 * 12), locale);
		assertEquals("12 minut nazaj", t.format(new Date(0)));
	}

	@Test
	public void testHoursFromNow() throws Exception {
		PrettyTime t = new PrettyTime(new Date(0), locale);
		assertEquals("čez 6 ur", t.format(new Date(1000 * 60 * 60 * 6)));
	}

	@Test
	public void testTwoHoursFromNow() throws Exception {
		PrettyTime t = new PrettyTime(new Date(0), locale);
		assertEquals("čez 2 uri", t.format(new Date(1000 * 60 * 60 * 2)));
	}
}
