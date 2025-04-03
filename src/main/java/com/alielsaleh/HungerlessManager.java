package com.alielsaleh;

import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.server.network.ServerPlayerEntity;

public class HungerlessManager extends HungerManager {
    private static final int MAX_FOOD_LEVEL = 20;
    private static final float MAX_SATURATION_LEVEL = MAX_FOOD_LEVEL;

    private final PlayerEntity player;

    public HungerlessManager(PlayerEntity player) {
        this.player = player;
    }

    public void add(int health) {
        player.heal(health);
    }

    @Override
    public void add(int hunger, float saturation) {
        add(hunger);
    }

    @Override
    public void eat(FoodComponent foodComponent) {
        add(foodComponent.nutrition());
    }

    @Override
    public void update(ServerPlayerEntity playerEntity) {
    }

    @Override
    public int getFoodLevel() {
        return MAX_FOOD_LEVEL;
    }

    @Override
    public boolean isNotFull() {
        return player.getHealth() < player.getMaxHealth();
    }

    @Override
    public void addExhaustion(float exhaustion) {
    }

    @Override
    public float getSaturationLevel() {
        return MAX_SATURATION_LEVEL;
    }

    @Override
    public void setFoodLevel(int foodLevel) {
    }

    @Override
    public void setSaturationLevel(float saturationLevel) {
    }
}