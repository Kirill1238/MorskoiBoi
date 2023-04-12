import java.util.ArrayList;

public class DotComBust {
    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numofGuesses = 0;
    private void setUpGame(){
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);
        System.out.println("���� ���� - �������� ��� \"�����\".");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("����������� �������� �� �� ����������� ���������� �����.");
        for (DotCom dotComToSet : dotComsList){
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }
    private void startPlaying(){
        while (!dotComsList.isEmpty()){
            numofGuesses++;
            String userGuess = helper.getUserInput("�������� ���:" + numofGuesses);
            checkUserGuesses(userGuess);
        }
        finishGame();
    }
    private void checkUserGuesses(String userGuess){
        String result = "����";
        for (DotCom dotComToTest : dotComsList){
            result = dotComToTest.checkYourSelf(userGuess);
            if (result.equals("�����")){
                break;
            }
            if(result.equals("�������!")){
                dotComsList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }
    private void finishGame(){
        System.out.println("��� \"�����\" ���� �� ���! ���� ����� ������ ������ �� �����.");
        if (numofGuesses <= 18 ){
            System.out.println("��� ������ � ��� �����: " + numofGuesses + "�������(�).");
            System.out.println("�� ������ ��������� �� ����, ��� ���� �������� �������.");
        } else{
            System.out.println("��� ������ � ��� �������� ����� �������: " + numofGuesses + " �������(�).");
            System.out.println("���� ����� �������� ������ ����� ��������.");
        }
    }
}