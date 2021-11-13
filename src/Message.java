public class Message {
    private final String messageContext;
    private final Boolean isUrgent;

    public Message(String messageContext,Boolean isUrgent) {
        this.messageContext = messageContext;
        this.isUrgent = isUrgent;
    }

    public String getMessageContext() {
        return messageContext;
    }

    public Boolean getUrgent() {
        return isUrgent;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageContext='" + messageContext + '\'' +
                ", isUrgent=" + isUrgent +
                '}';
    }


    static class Builder{
        private String messageContext;
        private Boolean isUrgent;


        public Builder(String messageContext, boolean isUrgentFinal) {
            this.messageContext = messageContext;
            this.isUrgent = Boolean.FALSE;
        }


        public Builder isUrgent(Boolean isUrgent){
            this.isUrgent = isUrgent;
            return this;
        }

        public Message build(){
            return new Message(messageContext,isUrgent);
        }
    }


}
