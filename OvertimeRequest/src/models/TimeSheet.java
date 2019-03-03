/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author milhamafemi
 */
@Entity
@Table(name = "TIME_SHEET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TimeSheet.findAll", query = "SELECT t FROM TimeSheet t")
    , @NamedQuery(name = "TimeSheet.findById", query = "SELECT t FROM TimeSheet t WHERE t.id = :id")
    , @NamedQuery(name = "TimeSheet.findByTimeSheetDate", query = "SELECT t FROM TimeSheet t WHERE t.timeSheetDate = :timeSheetDate")
    , @NamedQuery(name = "TimeSheet.findByName", query = "SELECT t FROM TimeSheet t WHERE t.name = :name")})
public class TimeSheet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "TIME_SHEET_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeSheetDate;
    @Column(name = "NAME")
    private String name;
    @JoinColumn(name = "EMPLOYEE", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;
    @OneToMany(mappedBy = "timeSheet", fetch = FetchType.LAZY)
    private Collection<Overtime> overtimeCollection;

    public TimeSheet() {
    }

    public TimeSheet(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTimeSheetDate() {
        return timeSheetDate;
    }

    public void setTimeSheetDate(Date timeSheetDate) {
        this.timeSheetDate = timeSheetDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @XmlTransient
    public Collection<Overtime> getOvertimeCollection() {
        return overtimeCollection;
    }

    public void setOvertimeCollection(Collection<Overtime> overtimeCollection) {
        this.overtimeCollection = overtimeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TimeSheet)) {
            return false;
        }
        TimeSheet other = (TimeSheet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.TimeSheet[ id=" + id + " ]";
    }
    
}
