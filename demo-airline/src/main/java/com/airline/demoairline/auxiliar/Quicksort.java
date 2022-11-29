package com.airline.demoairline.auxiliar;

import com.airline.demoairline.model.Flight;

import java.util.List;

public class Quicksort {

    private int partition (List<Flight> a, int start, int end)
    {
        Long pivot, ni, nj;
        String departure = a.get(end).getDeparture();
        pivot = a.get(end).getDepartureSecs(); // pivot element

        int i = (start - 1);

        for (int j = start; j <= end - 1; j++)
        {
            nj = a.get(j).getDepartureSecs();
            // If current element is smaller than the pivot
            if (nj < pivot)
            {
                i++; // increment index of smaller element
                long t = a.get(i).getDepartureSecs();
                a.get(i).setDepartureSecs(a.get(j).getDepartureSecs());
                a.get(j).setDepartureSecs(t);
            }
        }
        long t = a.get(i+1).getDepartureSecs();
        a.get(i+1).setDepartureSecs(a.get(end).getDepartureSecs());
        a.get(end).setDepartureSecs(t);

        return (i + 1);
    }


    /* function to implement quick sort */
    public void quick(List<Flight> a, int start, int end) /* a[] = array to be sorted, start = Starting index, end = Ending index */
    {
        if (start < end)
        {
            int p = partition(a, start, end);  //p is partitioning index
            quick(a, start, p - 1);
            quick(a, p + 1, end);
        }
    }


}
