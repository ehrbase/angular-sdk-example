package org.ehrbase.numappbackend.opt.openereactcarecomposition.definition;

import com.nedap.archie.rm.datastructures.Cluster;
import java.util.List;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.OptionFor;
import org.ehrbase.client.annotations.Path;

@Entity
@OptionFor("CLUSTER")
public class Covid19ExposureDetailCluster implements Covid19ExposureDetailChoice {
  @Path("")
  private List<Cluster> detail;

  public void setDetail(List<Cluster> detail) {
     this.detail = detail;
  }

  public List<Cluster> getDetail() {
     return this.detail ;
  }
}
