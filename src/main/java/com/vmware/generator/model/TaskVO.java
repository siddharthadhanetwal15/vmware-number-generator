package com.vmware.generator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TaskVO {
    @Id
    @JsonProperty("task")
    private String uuid;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int goal;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int step;

    @JsonIgnore
    private StatusEnum status;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getGoal() {
        return goal;
    }

    @JsonProperty("Goal")
    public void setGoal(int goal) {
        this.goal = goal;
    }

    public int getStep() {
        return step;
    }

    @JsonProperty("Step")
    public void setStep(int step) {
        this.step = step;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
