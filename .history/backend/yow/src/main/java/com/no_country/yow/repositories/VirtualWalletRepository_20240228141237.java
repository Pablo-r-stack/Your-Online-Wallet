package com.no_country.yow.repositories;

import com.no_country.yow.models.VirtualWallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VirtualWalletRepository extends JpaRepository<VirtualWallet, String> {
}
