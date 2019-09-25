package com.telus.testtelus.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telus.testtelus.entity.Candidate;
import com.telus.testtelus.entity.Committee;
import com.telus.testtelus.model.CommitteeModel;
import com.telus.testtelus.repository.CandidateRepository;
import com.telus.testtelus.repository.CommitteeRepository;

@Service("committeeServiceImpl")
public class CommitteeServiceImpl {

	
	@Autowired
	private CommitteeRepository committeeRepository;
	
	@Autowired
	private CandidateRepository candidateRepository;
	
	
	@PersistenceContext
	private EntityManager em;
	 
	 

	public List<Committee> findByCountry(Integer idCountry) {

		return committeeRepository.findByCountry(idCountry);
	}
	
	
	public List<Candidate> findCandidatesByCommittee(Integer id) {

		return candidateRepository.findByCommitteeId(id);
	}
	
	
	public Committee findOneById(Integer idCommittee) {

		return committeeRepository.findOneById(idCommittee);
	}
	
	
	@Transactional
	public List<CommitteeModel>  getCommitteesStatistics() {


		List<CommitteeModel>  committeesStatistics = new ArrayList<CommitteeModel>();

		List<Committee> committees = committeeRepository.findAllSortAsc();

		for (Committee committee : committees) {
			CommitteeModel cm = new CommitteeModel();
			
			cm.setName(committee.getName());
			cm.setCandidates(committee.getCandidateList().size());
			cm.setCountry(committee.getDepartmentId().getAreaId().getCountryId().getName());
			cm.setDepartment(committee.getDepartmentId().getName());
			
			
			
			String mostVotedCandidate ="";
			
			/**
			 * get the most voted candidate by committee
			 */
			
			Query query = em.createNativeQuery("SELECT c.name as idCandidate, c.surname as surname, count(v.id) as votes "
					+ "FROM candidate c "
					+ "INNER JOIN vote v ON c.id = v.candidate_id "
					+ "INNER JOIN committee co ON c.committee_id = co.id "
					+ "WHERE co.id =:id_committee GROUP BY  c.id  Order BY votes desc limit 1 ");
			
			  query.setParameter("id_committee", committee.getId());
			
			 List<Object[]> data = query.getResultList();
			 
			 for (Object c[] : data) {
				 mostVotedCandidate = c[0]+" "+c[1]+ " | #"+c[2];
				 break;
			}
			
			
			
			
			cm.setMostVotedCandidate(mostVotedCandidate );
			
			committeesStatistics.add(cm);
		}
		
		return committeesStatistics;
	}
	
	
	
	
}
