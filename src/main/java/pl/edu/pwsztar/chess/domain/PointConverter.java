package pl.edu.pwsztar.chess.domain;

class PointConverter {

    private final char[] letterArray = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};


    Point convert(String location) {

        char s = location.substring(0, 1).charAt(0);
        int y = Integer.parseInt(location.substring(2));
        int x = 0;

        for (int i = 0; i < letterArray.length; i++) {
            if (s == letterArray[i]) {
                x = i + 1;
            }
        }

        return new Point(x,y);
    }


}