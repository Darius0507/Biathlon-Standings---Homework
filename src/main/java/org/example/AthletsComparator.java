package org.example;

import java.util.Comparator;

public class AthletsComparator implements Comparator<AthletsResults> {

  @Override
  public int compare(AthletsResults o1, AthletsResults o2) {
    return Integer.compare(o1.getTotalTime(), o2.getTotalTime());
  }
}
