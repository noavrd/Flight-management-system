interface Notification {
    /**
     *
     * @return register to notifications.
    */
    void register(Observer observer);
    /**
     *
     * @return remove from notifications.
    */
    void remove(Observer observer);
}