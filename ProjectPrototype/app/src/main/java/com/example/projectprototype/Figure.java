package com.example.projectprototype;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Figure {

    public int i;
    public int j;
    public int figureKey;
    public int imageButton;

    public Figure() {
        this.figureKey = 10;
        this.imageButton = 0;
    }

    class ArraysHelper {

        private final TextView textView;
        private int gamePoints;
        private final ImageButton[][] buttons = new ImageButton[7][7];
        private final Figure[][] array = new Figure[7][7];

        public ArraysHelper(TextView textView) {
            this.textView = textView;
        }

        public void fillArray() {
            for (int i = 0; i < array.length; i++) {
                int[] vCounter = new int[]{5, 5, 5};
                for (int j = 0; j < array[i].length; j++) {
                    if (i > 1) {
                        array[i][j] = randomize(i, j);
                        vCounter[0] = vCounter[1];
                        vCounter[1] = vCounter[2];
                        vCounter[2] = array[i][j].figureKey;
                        if ((vCounter[0] == vCounter[1] && vCounter[2] == vCounter[0]) |
                                (array[i - 2][j].figureKey == array[i - 1][j].figureKey && array[i][j].figureKey == array[i - 1][j].figureKey)) {
                            while ((vCounter[0] == vCounter[1] && vCounter[2] == vCounter[0]) |
                                    (array[i - 2][j].figureKey == array[i - 1][j].figureKey && array[i][j].figureKey == array[i - 1][j].figureKey)) {
                                array[i][j] = randomize(array[i][j].figureKey, i, j);
                                vCounter[2] = array[i][j].figureKey;
                            }
                        }
                    } else {
                        array[i][j] = randomize(i, j);
                        vCounter[0] = vCounter[1];
                        vCounter[1] = vCounter[2];
                        vCounter[2] = array[i][j].figureKey;
                        if (vCounter[0] == vCounter[1] && vCounter[2] == vCounter[0]) {
                            array[i][j] = randomize(array[i][j].figureKey, i, j);
                        }
                    }
                }
            }
        }

        private Figure randomize(int i, int j) {
            int a = (int) (Math.random() * 5);
            if (a == 0) return new Circle(i, j);
            else if (a == 1) return new Square(i, j);
            else if (a == 2) return new Triangle(i, j);
            else if (a == 3) return new Pentagon(i, j);
            return new Star(i, j);
        }

        private Figure randomize(int figureKey, int i, int j) {
            if (figureKey == 0) {
                int a = (int) (Math.random() * 4);
                if (a == 0) return new Square(i, j);
                else if (a == 1) return new Triangle(i, j);
                else if (a == 2) return new Pentagon(i, j);
                else if (a == 3) return new Star(i, j);
            } else if (figureKey == 1) {
                int a = (int) (Math.random() * 4);
                if (a == 0) return new Circle(i, j);
                else if (a == 1) return new Square(i, j);
                else if (a == 2) return new Pentagon(i, j);
                else if (a == 3) return new Star(i, j);
            } else if (figureKey == 2) {
                int a = (int) (Math.random() * 4);
                if (a == 0) return new Circle(i, j);
                else if (a == 1) return new Triangle(i, j);
                else if (a == 2) return new Pentagon(i, j);
                else if (a == 3) return new Star(i, j);
            } else if (figureKey == 3) {
                int a = (int) (Math.random() * 4);
                if (a == 0) return new Circle(i, j);
                else if (a == 1) return new Triangle(i, j);
                else if (a == 2) return new Square(i, j);
                else if (a == 3) return new Star(i, j);
            } else if (figureKey == 4) {
                int a = (int) (Math.random() * 4);
                if (a == 0) return new Circle(i, j);
                else if (a == 1) return new Square(i, j);
                else if (a == 2) return new Triangle(i, j);
            }
            return new Pentagon(i, j);
        }

        public boolean checkArray() {
            boolean checkNext = false;
            int intCounter = 0;
            for (int i = 0; i < array.length; i++) {
                int[] vCounter = new int[]{5, 5, 5};
                int[] hCounter = new int[]{5, 5, 5};
                for (int j = 0; j < array[i].length; j++) {
                    //VerticalCounting
                    vCounter[0] = vCounter[1];
                    vCounter[1] = vCounter[2];
                    vCounter[2] = array[i][j].figureKey;
                    if ((vCounter[0] == vCounter[1] && vCounter[2] == vCounter[0])) {
                        checkNext = true;
                        if (array[i].length - 1 > j) {
                            int help = j;
                            while (help + 1 < array[i].length) {
                                if (array[i][help].figureKey == array[i][help + 1].figureKey) {
                                    intCounter++;
                                    help++;
                                } else break;
                            }
                        }
                        for (int a = j + intCounter; a - intCounter >= 3; a--) {
                            array[i][a] = array[i][a - (3 + intCounter)];
                        }
                        for (int a = 0; a <= 2 + intCounter; a++) {
                            gamePoints++;
                            String str = "POINTS: " + gamePoints;
                            textView.setText(str);
                            array[i][a] = randomize(i, j);
                        }
                        if (j + intCounter < array[i].length) j += intCounter;
                        intCounter = 0;

                    }
                    //horizontalCounting
                    hCounter[0] = hCounter[1];
                    hCounter[1] = hCounter[2];
                    hCounter[2] = array[j][i].figureKey;
                    if (hCounter[0] == hCounter[1] && hCounter[2] == hCounter[0] && hCounter[1] != 9) {
                        checkNext = true;
                        if (array[j].length - 1 > j) {
                            int help = j;
                            while (help + 1 < array.length) {
                                if (array[help][i].figureKey == array[help + 1][i].figureKey) {
                                    intCounter++;
                                    help++;
                                } else break;
                            }
                        }
                        for (int a = j - 2; a <= j + intCounter; a++) {
                            int counter = i;
                            while (counter > 0) {
                                array[a][counter] = array[a][counter - 1];
                                counter--;
                            }
                            gamePoints++;
                            String str = "POINTS: " + gamePoints;
                            textView.setText(str);
                            array[a][0] = randomize(i, j);
                        }
                        if (j + intCounter < array.length) j += intCounter;
                        intCounter = 0;
                    }
                }
            }
            return checkNext;
        }

        public int getGamePoints() {
            return gamePoints;
        }

        public boolean threeInARow(int i, int j, int i1, int j1) {
            if (i1 != i) {
                //Objects moving horizontal
                // j = j1
                if (i1 > i) {
                    //Moving to right
                    //horizontal
                    if (i - 2 >= 0) {
                        if (array[i - 2][j].figureKey == array[i - 1][j].figureKey && array[i - 1][j].figureKey == array[i1][j].figureKey) {
                            return swapItems(i, j, i1, j1);
                        }
                    }
                    if (i - 1 >= 0) {
                        if (array[i - 1][j].figureKey == array[i1][j].figureKey && array[i1][j].figureKey == array[i][j].figureKey) {
                            return swapItems(i, j, i1, j1);
                        }
                    }
                    if (i1 + 1 < array.length) {
                        if (array[i1][j].figureKey == array[i][j].figureKey && array[i][j].figureKey == array[i1 + 1][j].figureKey) {
                            return swapItems(i, j, i1, j1);
                        }
                    }
                    if (i1 + 2 < array.length) {
                        if (array[i][j].figureKey == array[i1 + 1][j].figureKey && array[i1 + 1][j].figureKey == array[i1 + 2][j].figureKey) {
                            return swapItems(i, j, i1, j1);
                        }
                    }
                } else {
                    //Moving to left
                    //i1 < i
                    //horizontal
                    if (i1 - 2 >= 0) {
                        if (array[i1 - 2][j].figureKey == array[i1 - 1][j].figureKey && array[i1 - 1][j].figureKey == array[i][j].figureKey) {
                            return swapItems(i, j, i1, j1);
                        }
                    }
                    if (i1 - 1 >= 0) {
                        if (array[i1 - 1][j].figureKey == array[i][j].figureKey && array[i][j].figureKey == array[i1][j].figureKey) {
                            return swapItems(i, j, i1, j1);
                        }
                    }
                    if (i + 1 < array.length) {
                        if (array[i][j].figureKey == array[i1][j].figureKey && array[i1][j].figureKey == array[i + 1][j].figureKey) {
                            return swapItems(i, j, i1, j1);
                        }
                    }
                    if (i + 2 < array.length) {
                        if (array[i1][j].figureKey == array[i + 1][j].figureKey && array[i + 1][j].figureKey == array[i + 2][j].figureKey) {
                            return swapItems(i, j, i1, j1);
                        }
                    }

                }
                //vertical part is common
                if (j - 2 >= 0) {
                    if (array[i1][j].figureKey == array[i][j - 1].figureKey && array[i][j - 1].figureKey == array[i][j - 2].figureKey) {
                        return swapItems(i, j, i1, j1);
                    }
                    if (array[i][j].figureKey == array[i1][j - 1].figureKey && array[i1][j - 1].figureKey == array[i1][j - 2].figureKey) {
                        return swapItems(i, j, i1, j1);
                    }
                }
                if (j - 1 >= 0 && j + 1 < array.length) {
                    if (array[i1][j].figureKey == array[i][j - 1].figureKey && array[i1][j].figureKey == array[i][j + 1].figureKey) {
                        return swapItems(i, j, i1, j1);
                    }
                    if (array[i][j].figureKey == array[i1][j - 1].figureKey && array[i][j].figureKey == array[i1][j + 1].figureKey) {
                        return swapItems(i, j, i1, j1);
                    }
                }
                if (j + 2 < array.length) {
                    if (array[i1][j].figureKey == array[i][j + 1].figureKey && array[i][j + 1].figureKey == array[i][j + 2].figureKey) {
                        return swapItems(i, j, i1, j1);
                    }
                    if (array[i][j].figureKey == array[i1][j + 1].figureKey && array[i1][j + 1].figureKey == array[i1][j + 2].figureKey) {
                        return swapItems(i, j, i1, j1);
                    }
                }
            } else {
                //Objects moving vertical
                if (j < j1) {
                    //vertical
                    if (j - 2 >= 0) {
                        if (array[i][j - 2].figureKey == array[i][j1].figureKey && array[i][j - 1].figureKey == array[i][j1].figureKey) {
                            return swapItems(i, j, i1, j1);
                        }
                    }
                    if (j - 1 >= 0) {
                        if (array[i][j - 1].figureKey == array[i][j1].figureKey && array[i][j1].figureKey == array[i][j].figureKey) {
                            return swapItems(i, j, i1, j1);
                        }
                    }
                    if (j1 + 1 < array.length) {
                        if (array[i][j1].figureKey == array[i][j].figureKey && array[i][j].figureKey == array[i][j1 + 1].figureKey) {
                            return swapItems(i, j, i1, j1);
                        }
                    }
                    if (j1 + 2 < array.length) {
                        if (array[i][j].figureKey == array[i][j1 + 1].figureKey && array[i][j1 + 1].figureKey == array[i][j1 + 2].figureKey) {
                            return swapItems(i, j, i1, j1);
                        }
                    }

                } else {
                    //j > j1
                    //vertical
                    if (j1 - 2 >= 0) {
                        if (array[i][j].figureKey == array[i][j1 - 1].figureKey && array[i][j1 - 1].figureKey == array[i][j1 - 2].figureKey) {
                            return swapItems(i, j, i1, j1);
                        }
                    }
                    if (j1 - 1 >= 0) {
                        if (array[i][j].figureKey == array[i][j1 - 1].figureKey && array[i][j].figureKey == array[i][j1].figureKey) {
                            return swapItems(i, j, i1, j1);
                        }
                    }
                    if (j + 1 < array.length) {
                        if (array[i][j].figureKey == array[i][j1].figureKey && array[i][j1].figureKey == array[i][j + 1].figureKey) {
                            return swapItems(i, j, i1, j1);
                        }
                    }
                    if (j + 2 < array.length) {
                        if (array[i][j1].figureKey == array[i][j + 1].figureKey && array[i][j + 1].figureKey == array[i][j + 2].figureKey) {
                            return swapItems(i, j, i1, j1);
                        }
                    }
                }
                //horizontal part is common
                if (i - 2 >= 0) {
                    if (array[i][j].figureKey == array[i - 1][j1].figureKey && array[i - 1][j1].figureKey == array[i - 2][j1].figureKey) {
                        return swapItems(i, j, i1, j1);
                    }
                    if (array[i][j1].figureKey == array[i - 1][j].figureKey && array[i - 1][j].figureKey == array[i - 2][j].figureKey) {
                        return swapItems(i, j, i1, j1);
                    }
                }
                if (i - 1 >= 0 && i + 1 < array.length) {
                    if (array[i][j].figureKey == array[i - 1][j1].figureKey && array[i][j].figureKey == array[i + 1][j1].figureKey) {
                        return swapItems(i, j, i1, j1);
                    }
                    if (array[i][j1].figureKey == array[i - 1][j].figureKey && array[i][j1].figureKey == array[i + 1][j].figureKey) {
                        return swapItems(i, j, i1, j1);
                    }
                }
                if (i + 2 < array.length) {
                    if (array[i][j].figureKey == array[i + 1][j1].figureKey && array[i + 1][j1].figureKey == array[i + 2][j1].figureKey) {
                        return swapItems(i, j, i1, j1);
                    }
                    if (array[i][j1].figureKey == array[i + 1][j].figureKey && array[i + 1][j].figureKey == array[i + 2][j].figureKey) {
                        return swapItems(i, j, i1, j1);
                    }
                }
            }
            return false;
        }

        private boolean swapItems(int i, int j, int i1, int j1) {
            Figure figure = array[i][j];
            array[i][j] = array[i1][j1];
            array[i1][j1] = figure;
            return true;
        }

        public void putButton(int i, int j, ImageButton button) {
            buttons[i][j] = button;
        }

        private void setClicksAround(int i, int j) {
            if (i + 1 < buttons.length) {
                buttons[i + 1][j].setOnClickListener(v -> {
                    if (threeInARow(i, j, i + 1, j)) {
                        updateMatrix();
                    } else {
                        buttons[i + 1][j].setOnClickListener(v1 -> setClicksAround(i + 1, j));
                    }
                });
            }
            if (i - 1 >= 0) {
                buttons[i - 1][j].setOnClickListener(v -> {
                    if (threeInARow(i, j, i - 1, j)) {
                        updateMatrix();
                    } else {
                        buttons[i - 1][j].setOnClickListener(v1 -> setClicksAround(i - 1, j));
                    }
                });
            }
            if (j + 1 < buttons[i].length) {
                buttons[i][j + 1].setOnClickListener(v -> {
                    if (threeInARow(i, j, i, j + 1)) {
                        updateMatrix();
                    } else {
                        buttons[i][j + 1].setOnClickListener(v1 -> setClicksAround(i, j + 1));
                    }
                });
            }
            if (j - 1 >= 0) {
                buttons[i][j - 1].setOnClickListener(v -> {
                    if (threeInARow(i, j, i, j - 1)) {
                        updateMatrix();
                    } else {
                        buttons[i][j - 1].setOnClickListener(v1 -> setClicksAround(i, j - 1));
                    }
                });
            }
        }

        public void setButtons() {

            for (int i = 0; i < 7; i++) {
                final int i1 = i;
                for (int j = 0; j < 7; j++) {
                    final int j1 = j;
                    buttons[i][j].setImageResource(array[i][j].imageButton);
                    buttons[i][j].setOnClickListener(v -> {
                        setClicksAround(i1, j1);
                    });

                }
            }
        }

        private void updateMatrix() {

            while (checkArray()) {
                setButtons();
            }
        }
    }
}
