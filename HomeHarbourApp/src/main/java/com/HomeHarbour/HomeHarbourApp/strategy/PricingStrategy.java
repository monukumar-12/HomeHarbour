package com.HomeHarbour.HomeHarbourApp.strategy;

import com.HomeHarbour.HomeHarbourApp.entity.Inventory;

import java.math.BigDecimal;

public interface PricingStrategy {

    BigDecimal calculatePrice(Inventory inventory);
}


