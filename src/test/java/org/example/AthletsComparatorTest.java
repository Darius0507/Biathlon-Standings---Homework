package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AthletsComparatorTest {

  @Test
  void compare() {
    // given

    AthletsResults a1 = new AthletsResults(1, "David", "RO", "30:00", "xxxxx", "xxxxx", "xxxxx");
    AthletsResults a2 = new AthletsResults(2, "Robert", "ES", "35:00", "xxxxx", "xxxxx", "xxxxx");
    AthletsComparator comparator = new AthletsComparator();

    // when
    int compareResult = comparator.compare(a1, a2);

    // then

    assertTrue(compareResult < 0);
  }
}
