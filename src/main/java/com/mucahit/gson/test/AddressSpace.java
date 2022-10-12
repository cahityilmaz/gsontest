package com.mucahit.gson.test;

/**
 *
 * @author mucahit.yilmaz
 */
public class AddressSpace {

    private final String addressSpaceName;
    private final int priority;

    public AddressSpace(String addressSpaceName, int priority) {
        this.addressSpaceName = addressSpaceName;
        this.priority = priority;
    }

    public String getAddressSpaceName() {
        return addressSpaceName;
    }

    public int getPriority() {
        return priority;
    }

}
