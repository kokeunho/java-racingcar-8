package racingcar.game;

import racingcar.car.Car;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Car> carList;
    private final int tryCount;

    public Game(String carNames, int tryCount) {
        this.carList = createCarList(carNames);
        this.tryCount = tryCount;
    }

    private List<Car> createCarList(String carNames) {
        List<Car> carList = new ArrayList<>();

        for (String name : carNames.trim().split(",")) {
            carList.add(new Car(name.trim()));
        }

        return carList;
    }

    private void playRound() {
        for (Car car : carList) {
            car.moveCar();
        }
    }

    private void printRoundResult() {
        for (Car car : carList) {
            String carPosition = "-".repeat(car.getPosition());
            System.out.println(car.getName() + " : " + carPosition);
        }
        System.out.println();
    }

    public void start() {
        System.out.println("\n실행 결과");

        for (int i = 0; i < tryCount; i++) {
            playRound();
            printRoundResult();
        }
    }

    public List<String> getWinners() {
        int maxPosition = 0;

        for (Car car : carList) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        List<String> winners = new ArrayList<>();

        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}
