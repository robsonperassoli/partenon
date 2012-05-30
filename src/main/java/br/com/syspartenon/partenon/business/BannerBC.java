package br.com.syspartenon.partenon.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.Banner;
import br.com.syspartenon.partenon.domain.Site;
import br.com.syspartenon.partenon.persistence.BannerDAO;
import br.com.syspartenon.partenon.util.FileUtil;
import br.com.syspartenon.partenon.util.UniqId;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@BusinessController
public class BannerBC extends DelegateCrud<Banner, Integer, BannerDAO> {
    public List<Banner> findAll(Site site) {
        return getDelegate().findAll(site);
    }    
    
    public void insert(Banner banner, byte[] imgContent, String fileName) {
        try {
            String filename = UniqId.getInstance().getUniqIDHashString() + "." + FileUtil.getExtension(fileName);
            String filePath = FileUtil.getImgDir() + filename;

            BufferedImage bfImg = org.alfredlibrary.utilitarios.io.Imagem.obterBufferedImage(imgContent);
            BufferedImage bfImagem = org.alfredlibrary.utilitarios.io.Imagem.redimensionar(bfImg, 930, 320, true);

            org.alfredlibrary.utilitarios.io.Imagem.salvarImagem(bfImagem, filePath);

            banner.setBanNome(filename);
            super.insert(banner);
        } catch (Exception e) {
            Logger.getLogger("BannerBC").log(Level.SEVERE,e.getMessage());
        }

    }
}
