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
package org.ocpsoft.prettytime.i18n;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListResourceBundle;
import java.util.ResourceBundle;
import org.ocpsoft.prettytime.Duration;
import org.ocpsoft.prettytime.TimeFormat;
import org.ocpsoft.prettytime.TimeUnit;
import org.ocpsoft.prettytime.format.SimpleTimeFormat;
import org.ocpsoft.prettytime.impl.TimeFormatProvider;
import org.ocpsoft.prettytime.units.Day;
import org.ocpsoft.prettytime.units.Hour;
import org.ocpsoft.prettytime.units.JustNow;
import org.ocpsoft.prettytime.units.Minute;
import org.ocpsoft.prettytime.units.Month;
import org.ocpsoft.prettytime.units.Week;
import org.ocpsoft.prettytime.units.Year;

public class Resources_sl extends ListResourceBundle implements TimeFormatProvider {

	private static final Object[][] OBJECTS = new Object[][]{
		{"CenturyPattern", "%n %u"},
		{"CenturyFuturePrefix", "čez "},
		{"CenturyFutureSuffix", ""},
		{"CenturyPastPrefix", ""},
		{"CenturyPastSuffix", "nazaj"},
		{"CenturySingularName", "stoletje"},
		{"CenturyPluralName", "stoletij"},
		{"DayPattern", "%n %u"},
		{"DayFuturePrefix", "čez "},
		{"DayFutureSuffix", ""},
		{"DayPastPrefix", ""},
		{"DayPastSuffix", "nazaj"},
		{"DaySingularName", "dan"},
		{"DayPluralName", "dni"},
		{"DecadePattern", "%n %u"},
		{"DecadeFuturePrefix", "čez "},
		{"DecadeFutureSuffix", ""},
		{"DecadePastPrefix", ""},
		{"DecadePastSuffix", "nazaj"},
		{"DecadeSingularName", "desetletje"},
		{"DecadePluralName", "desetletij"},
		{"HourPattern", "%n %u"},
		{"HourFuturePrefix", "čez "},
		{"HourFutureSuffix", ""},
		{"HourPastPrefix", ""},
		{"HourPastSuffix", "nazaj"},
		{"HourSingularName", "uro"},
		{"HourPluralName", "ur"},
		{"JustNowPattern", "%u"},
		{"JustNowFuturePrefix", "čez "},
		{"JustNowFutureSuffix", "pravkar"},
		{"JustNowPastPrefix", "trenutkov nazaj"},
		{"JustNowPastSuffix", ""},
		{"JustNowSingularName", ""},
		{"JustNowPluralName", ""},
		{"MillenniumPattern", "%n %u"},
		{"MillenniumFuturePrefix", "čez "},
		{"MillenniumFutureSuffix", ""},
		{"MillenniumPastPrefix", ""},
		{"MillenniumPastSuffix", "nazaj"},
		{"MillenniumSingularName", "tisočletje"},
		{"MillenniumPluralName", "tisočletij"},
		{"MillisecondPattern", "%n %u"},
		{"MillisecondFuturePrefix", "čez "},
		{"MillisecondFutureSuffix", ""},
		{"MillisecondPastPrefix", ""},
		{"MillisecondPastSuffix", "nazaj"},
		{"MillisecondSingularName", "milisekundo"},
		{"MillisecondPluralName", "milisekund"},
		{"MinutePattern", "%n %u"},
		{"MinuteFuturePrefix", "čez "},
		{"MinuteFutureSuffix", ""},
		{"MinutePastPrefix", ""},
		{"MinutePastSuffix", "nazaj"},
		{"MinuteSingularName", "minuto"},
		{"MinutePluralName", "minut"},
		{"MonthPattern", "%n %u"},
		{"MonthFuturePrefix", "čez "},
		{"MonthFutureSuffix", ""},
		{"MonthPastPrefix", ""},
		{"MonthPastSuffix", "nazaj"},
		{"MonthSingularName", "mesec"},
		{"MonthPluralName", "mesecev"},
		{"SecondPattern", "%n %u"},
		{"SecondFuturePrefix", "čez "},
		{"SecondFutureSuffix", ""},
		{"SecondPastPrefix", ""},
		{"SecondPastSuffix", "nazaj"},
		{"SecondSingularName", "sekundo"},
		{"SecondPluralName", "sekund"},
		{"WeekPattern", "%n %u"},
		{"WeekFuturePrefix", "čez "},
		{"WeekFutureSuffix", ""},
		{"WeekPastPrefix", ""},
		{"WeekPastSuffix", "nazaj"},
		{"WeekSingularName", "teden"},
		{"WeekPluralName", "tednov"},
		{"YearPattern", "%n %u"},
		{"YearFuturePrefix", "čez "},
		{"YearFutureSuffix", ""},
		{"YearPastPrefix", ""},
		{"YearPastSuffix", "nazaj"},
		{"YearSingularName", "leto"},
		{"YearPluralName", "let"},
		{"AbstractTimeUnitPattern", ""},
		{"AbstractTimeUnitFuturePrefix", ""},
		{"AbstractTimeUnitFutureSuffix", ""},
		{"AbstractTimeUnitPastPrefix", ""},
		{"AbstractTimeUnitPastSuffix", ""},
		{"AbstractTimeUnitSingularName", ""},
		{"AbstractTimeUnitPluralName", ""}};

	@Override
	protected Object[][] getContents() {
		return OBJECTS;
	}

	@Override
	public TimeFormat getFormatFor(TimeUnit t) {
		if (t instanceof JustNow) {
			return new TimeFormat() {
				@Override
				public String format(Duration duration) {
					return performFormat(duration);
				}

				@Override
				public String formatUnrounded(Duration duration) {
					return performFormat(duration);
				}

				private String performFormat(Duration duration) {
					if (duration.isInFuture()) {
						return "pravkar";
					}
					if (duration.isInPast()) {
						return "pravkar";
					}
					return null;
				}

				@Override
				public String decorate(Duration duration, String time) {
					return time;
				}

				@Override
				public String decorateUnrounded(Duration duration, String time) {
					return time;
				}
			};
		} else if (t instanceof Minute) {
			return new SlTimeFormatBuilder("Minute")
					.addFutureName("minuto", 1)
					.addFutureName("minuti", 2)
					.addFutureName("minute", 3)
					.addFutureName("minut", Long.MAX_VALUE)
					.addPastName("minuto", 1)
					.addPastName("minutama", 2)
					.addPastName("minut", Long.MAX_VALUE)
					.build(this);
		} else if (t instanceof Hour) {
			return new SlTimeFormatBuilder("Hour")
					.addFutureName("uro", 1)
					.addFutureName("uri", 2)
					.addFutureName("ure", 4)
					.addFutureName("ur", Long.MAX_VALUE)
					.addPastName("uro", 1)
					.addPastName("urama", 2)
					.addPastName("urami", Long.MAX_VALUE)
					.build(this);
		} else if (t instanceof Day) {
			return new SlTimeFormatBuilder("Day")
					.addFutureName("den", 1)
					.addFutureName("dny", 4)
					.addFutureName("dní", Long.MAX_VALUE)
					.addPastName("dnem", 1)
					.addPastName("dny", Long.MAX_VALUE)
					.build(this);
		} else if (t instanceof Week) {
			return new SlTimeFormatBuilder("Week")
					.addFutureName("týden", 1)
					.addFutureName("týdny", 4)
					.addFutureName("týdnů", Long.MAX_VALUE)
					.addPastName("týdnem", 1)
					.addPastName("týdny", Long.MAX_VALUE)
					.build(this);
		} else if (t instanceof Month) {
			return new SlTimeFormatBuilder("Month")
					.addFutureName("měsíc", 1)
					.addFutureName("měsíce", 4)
					.addFutureName("měsíců", Long.MAX_VALUE)
					.addPastName("měsícem", 1)
					.addPastName("měsíci", Long.MAX_VALUE)
					.build(this);
		} else if (t instanceof Year) {
			return new SlTimeFormatBuilder("Year")
					.addFutureName("rok", 1)
					.addFutureName("roky", 4)
					.addFutureName("let", Long.MAX_VALUE)
					.addPastName("rokem", 1)
					.addPastName("roky", Long.MAX_VALUE)
					.build(this);
		}
		// Don't override format for other time units
		return null; // error
	}

	private static class SlTimeFormatBuilder {

		private List<SlName> names = new ArrayList<Resources_sl.SlName>();

		private String resourceKeyPrefix;

		SlTimeFormatBuilder(String resourceKeyPrefix) {
			this.resourceKeyPrefix = resourceKeyPrefix;
		}

		SlTimeFormatBuilder addFutureName(String name, long limit) {
			return addName(true, name, limit);
		}

		SlTimeFormatBuilder addPastName(String name, long limit) {
			return addName(false, name, limit);
		}

		private SlTimeFormatBuilder addName(boolean isFuture, String name, long limit) {
			if (name == null) {
				throw new IllegalArgumentException();
			}
			names.add(new SlName(isFuture, name, limit));
			return this;
		}

		SlTimeFormat build(final ResourceBundle bundle) {
			return new SlTimeFormat(resourceKeyPrefix, bundle, names);
		}

	}

	private static class SlTimeFormat extends SimpleTimeFormat implements TimeFormat {

		private final List<SlName> futureNames = new ArrayList<Resources_sl.SlName>();

		private final List<SlName> pastNames = new ArrayList<Resources_sl.SlName>();

		public SlTimeFormat(String resourceKeyPrefix, ResourceBundle bundle, Collection<SlName> names) {
			setPattern(bundle.getString(resourceKeyPrefix + "Pattern"));
			setFuturePrefix(bundle.getString(resourceKeyPrefix + "FuturePrefix"));
			setFutureSuffix(bundle.getString(resourceKeyPrefix + "FutureSuffix"));
			setPastPrefix(bundle.getString(resourceKeyPrefix + "PastPrefix"));
			setPastSuffix(bundle.getString(resourceKeyPrefix + "PastSuffix"));
			setSingularName(bundle.getString(resourceKeyPrefix + "SingularName"));
			setPluralName(bundle.getString(resourceKeyPrefix + "PluralName"));

			try {
				setFuturePluralName(bundle.getString(resourceKeyPrefix + "FuturePluralName"));
			} catch (Exception e) {
			}
			try {
				setFutureSingularName((bundle.getString(resourceKeyPrefix + "FutureSingularName")));
			} catch (Exception e) {
			}
			try {
				setPastPluralName((bundle.getString(resourceKeyPrefix + "PastPluralName")));
			} catch (Exception e) {
			}
			try {
				setPastSingularName((bundle.getString(resourceKeyPrefix + "PastSingularName")));
			} catch (Exception e) {
			}

			for (SlName name : names) {
				if (name.isFuture()) {
					futureNames.add(name);
				} else {
					pastNames.add(name);
				}
			}
			Collections.sort(futureNames);
			Collections.sort(pastNames);
		}

		@Override
		protected String getGramaticallyCorrectName(Duration d, boolean round) {
			long quantity = Math.abs(getQuantity(d, round));
			if (d.isInFuture()) {
				return getGramaticallyCorrectName(quantity, futureNames);
			}
			return getGramaticallyCorrectName(quantity, pastNames);
		}

		private String getGramaticallyCorrectName(long quantity, List<SlName> names) {
			for (SlName name : names) {
				if (name.getThreshold() >= quantity) {
					return name.get();
				}
			}
			throw new IllegalStateException("Invalid resource bundle configuration");
		}

	}

	private static class SlName implements Comparable<SlName> {

		private final boolean isFuture;

		private final String value;

		private final Long threshold;

		public SlName(boolean isFuture, String value, Long threshold) {
			this.isFuture = isFuture;
			this.value = value;
			this.threshold = threshold;
		}

		public boolean isFuture() {
			return isFuture;
		}

		public String get() {
			return value;
		}

		public long getThreshold() {
			return threshold;
		}

		@Override
		public int compareTo(SlName o) {
			return threshold.compareTo(o.getThreshold());
		}

	}
}
