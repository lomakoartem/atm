package ua.atm.domain.atm;

import java.util.List;

/**
 * Created by a.lomako on 2/22/2017.
 * Represents  a response object for JSON.
 */
public class ResponseObject<E> {
    /**
     * List of Atm locations
     */
    private List<E> list;

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {

        this.list = list;
    }

}

