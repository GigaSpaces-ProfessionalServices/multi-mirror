package com.gigaspaces;

import org.openspaces.events.adapter.SpaceDataEvent;

/**
 * @author Svitlana_Pogrebna
 *
 */
public class Processor {

    private long workDuration = 100;

    /**
     * Sets the simulated work duration (in milliseconds). Defaut to 100.
     */
    public void setWorkDuration(long workDuration) {
        this.workDuration = workDuration;
    }

    /**
     * Process the given Data object and returning the processed Data.
     *
     * Can be invoked using OpenSpaces Events when a matching event occurs.
     */
    @SpaceDataEvent
    public Data processData(Data data) {
        // sleep to simulate some work
        try {
            Thread.sleep(workDuration);
        } catch (InterruptedException e) {
            // do nothing
        }
        data.setProcessed(true);
        data.setData("PROCESSED : " + data.getRawData());
        return data;
    }

}
