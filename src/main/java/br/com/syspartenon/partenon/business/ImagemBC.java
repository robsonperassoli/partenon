package br.com.syspartenon.partenon.business;

import br.com.syspartenon.partenon.domain.Comodo;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.Imagem;
import br.com.syspartenon.partenon.persistence.ImagemDAO;
import br.com.syspartenon.partenon.util.FileUtil;
import br.com.syspartenon.partenon.util.UniqId;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@BusinessController
public class ImagemBC extends DelegateCrud<Imagem, Integer, ImagemDAO> {

    public void insert(Comodo comodo, byte[] imgContent, String fileName) {
        try {
            String filename = UniqId.getInstance().getUniqIDHashString() + "." + FileUtil.getExtension(fileName);
            String filePath = FileUtil.getImgDir() + filename;
            String filePathThumb = FileUtil.getThumbDir() + filename;

            BufferedImage bfImg = org.alfredlibrary.utilitarios.io.Imagem.obterBufferedImage(imgContent);
            BufferedImage bfImagem = org.alfredlibrary.utilitarios.io.Imagem.redimensionar(bfImg, 500, 300, true);
            BufferedImage bfThumb = org.alfredlibrary.utilitarios.io.Imagem.redimensionar(bfImg, 150, 100, true);

            org.alfredlibrary.utilitarios.io.Imagem.salvarImagem(bfImagem, filePath);
            org.alfredlibrary.utilitarios.io.Imagem.salvarImagem(bfThumb, filePathThumb);

            Imagem img = new Imagem();
            img.setImgNome(filename);
            img.setComodo(comodo);
            super.insert(img);
        } catch (Exception e) {
            Logger.getLogger("ImagemBC").log(Level.SEVERE,e.getMessage());
        }

    }
    
    public List<Imagem> findAll(Comodo comodo) {
        return getDelegate().findAll(comodo);
    }
    
    
}
