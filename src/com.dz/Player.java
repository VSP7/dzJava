package com.dz;

public class Player {


    String chooseBot, chooseUser, nameBot, userName;

    Player(){

        switch (getRandomIntegerBetweenRange(1,3)){
            case 1: this.chooseBot = String.valueOf(VARIANTS.БУМАГА);
            break;
            case 2: this.chooseBot = String.valueOf(VARIANTS.КАМЕНЬ);
            break;
            case 3: this.chooseBot = String.valueOf(VARIANTS.НОЖНИЦЫ);
            break;
        }

        this.nameBot = "Bot";

    };

    enum VARIANTS{
        КАМЕНЬ,
        НОЖНИЦЫ,
        БУМАГА
    }

    // получает рандом целое число от min до max включительно
    int getRandomIntegerBetweenRange(int min, int max){
        int x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }

    // функция определяет кто победил
    String whoWins(String userName, String chooseUser){

        if(chooseUser.equalsIgnoreCase(this.chooseBot)) return "Ничья.";
        else if(
        (chooseUser.equalsIgnoreCase("БУМАГА") && this.chooseBot.equalsIgnoreCase("КАМЕНЬ"))
            ||
        (chooseUser.equalsIgnoreCase("НОЖНИЦЫ") && this.chooseBot.equalsIgnoreCase("БУМАГА"))
            ||
        (chooseUser.equalsIgnoreCase("КАМЕНЬ") && this.chooseBot.equalsIgnoreCase("НОЖНИЦЫ"))
        )   return "Победил "+ userName;
        else if(chooseUser.equalsIgnoreCase("БУМАГА") || chooseUser.equalsIgnoreCase("НОЖНИЦЫ")
        || chooseUser.equalsIgnoreCase("КАМЕНЬ"))  return "Победил "+this.nameBot;
        else return "недопустимое значение, повторите попытку";

    }
}
