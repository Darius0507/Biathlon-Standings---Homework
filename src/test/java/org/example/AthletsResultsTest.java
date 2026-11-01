package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AthletsResultsTest {

  @Test
  void getTimeInSecondstest() {
    // given
    AthletsResults athlet = new AthletsResults(1, "Mark", "UK", "30:15", "xxxxx", "xxxxx", "xxxxx");

    // when
    int time = athlet.getTimeInSeconds();

    // then
    assertEquals(1815, time);
  }

  @Test
  void getTotalTimeWhitNoMisses() {
    // given
    AthletsResults athlete = new AthletsResults(2, "Ion", "RO", "25:00", "xxxxx", "xxxxx", "xxxxx");

    // when
    int totalTime = athlete.getTotalTime();

    // then

    assertEquals(1500, totalTime);
  }

  @Test
  void getTotalTimeWhitMisses() {
    // given
    AthletsResults athlete =
        new AthletsResults(2, "Marco", "I", "25:00", "xxxox", "xoxxx", "oxxxx");

    // when
    int totalTime = athlete.getTotalTime();

    // then

    assertEquals(1530, totalTime);
  }
}
