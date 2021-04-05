package com.ifmo.jjd.exams.fitness;

import com.ifmo.jjd.exams.fitness.enums.PassType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.UUID;

public class Pass {
    private PassType type;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Visitor owner;
    private UUID uuid = UUID.randomUUID();

    public Pass(PassType type, Visitor owner) {
        setType(type);
        setOwner(owner);

        this.startDate = LocalDateTime.now();
        setEndDate(this.startDate, this.type);
    }

    private void setType(PassType type) {
        this.type = Objects.requireNonNull(type, "type -> Pass null");;
    }

    private void setEndDate(LocalDateTime startDate, PassType type) {
        if(Objects.isNull(type) || Objects.isNull(startDate)) throw new IllegalArgumentException("type || startDate = null");
        switch (type) {
            case DAY -> endDate = startDate.plusDays(1);
            case MONTHLY -> endDate = startDate.plusMonths(1);
            case FULL -> endDate = startDate.plusYears(1);
        }
    }

    private void setOwner(Visitor owner) {
        this.owner = Objects.requireNonNull(owner, "owner -> Pass null");
    }

    public PassType getType() {
        return type;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Visitor getOwner() {
        return owner;
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return "Pass{" +
                "type=" + type.getName() +
                ", startDate=" + startDate.format(DateTimeFormatter.ofPattern("DD.MMMM.YYYY"))+
                ", endDate=" + endDate.format(DateTimeFormatter.ofPattern("DD.MMMM.YYYY")) +
                ", owner=" + owner.toString() +
                '}';
    }

}
