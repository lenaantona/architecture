package ru.geekbrains.lesson8.views;

import ru.geekbrains.lesson8.models.Reservation;
import ru.geekbrains.lesson8.models.Table;
import ru.geekbrains.lesson8.presenters.View;
import ru.geekbrains.lesson8.presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;

public class BookingView implements View {


    private ViewObserver observer;

    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    public void showTables(Collection<Table> tables){
        for (Table table: tables) {
            System.out.println(table);
        }
    }

    @Override
    public void showReservation(Collection<Reservation> reservations) {
        for (Reservation reservation: reservations){
            System.out.println(reservation);
        }
    }


    @Override
    public void showReservationTableResult(int reservationNo) {
        if (reservationNo > 0){
            System.out.printf("Столик успешно забронирован. Номер вашей брони: #%d\n", reservationNo);
        }
        else {
            System.out.println("Что-то пошло не так, попробуйте повторить попытку позже.");
        }
    }

    @Override
    public void showReservationChange(Reservation reservation) {
        if (reservation != null){
            System.out.printf("Бронь успешно изменена. Номер брони: #%d\n", reservation.getId());
            System.out.println(reservation.toString());
        }
        else {
            System.out.println("Что-то пошло не так, попробуйте повторить попытку позже.");
        }
    }

    /**
     * Действие клиента (пользователь нажал на кнопку бронирования), бронирование столика
     * @param orderDate дата бронирования
     * @param tableNo номер столика
     * @param name Имя
     */
    @Override
    public void reservationTable(Date orderDate, int tableNo, String name){
        if (observer != null)
            observer.onReservationTable(orderDate, tableNo, name);
    }

    /**
     * TODO: Доработать самостоятельнов рамках домашней работы
     * Действие клиента (пользователь нажал на кнопку изменения резерва)
     * @param oldReservation идентификатор бронирования (старый)
     * @param reservationDate дата бронирования
     * @param tableNo столика
     * @param name Имя
     */
    @Override
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){
        if (observer != null)
            observer.onChangeReservationTable(oldReservation, reservationDate, tableNo, name);
    }

}
