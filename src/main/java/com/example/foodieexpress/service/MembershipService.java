package com.example.foodieexpress.service;

import com.foodieexpress.model.Company;
import com.foodieexpress.model.Membership;
import com.foodieexpress.repository.MembershipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MembershipService {

    private final MembershipRepository membershipRepository;
    private final CompanyService companyService;

    // Yeni bir üyelik kaydeder
    public void save(Membership membership) {
        membershipRepository.save(membership);
    }

    // Belirli tarihler arasında üyeliği sona erecek şirketleri alır
    public List<Company> getCompaniesWithExpiringMemberships(LocalDate now, LocalDate oneMonthLater) {
        List<Long> expiringCompanyIds = membershipRepository.findExpiringCompanyIds(now, oneMonthLater);
        return companyService.findCompaniesByIds(expiringCompanyIds);
    }

    // Üyelik ID'sine göre üyelik getirir
    public Membership getMembershipById(Long membershipId) {
        return membershipRepository.findById(membershipId)
                .orElseThrow(() -> new RuntimeException("Membership not found with id: " + membershipId));
    }

    // Üyelik silme
    public void deleteMembership(Long membershipId) {
        membershipRepository.deleteById(membershipId);
    }
}
