package gchsj;

import gchsj.dao.CodeDao;
import gchsj.model.Code;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Code> cmtCodeCdList = CodeDao.selectAll();
        System.out.println("total size: " + cmtCodeCdList.size());

        List<Code> target = cmtCodeCdList.stream().filter(code -> code.getCodeSeq() == null).collect(Collectors.toList());
        System.out.println("update size: " + target.size());

        System.out.println("update start");
        for (Code code : target) {
            CodeDao.update(code);
        }
        System.out.println("update end");
    }
}
